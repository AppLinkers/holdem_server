package hello.hellospring.service;

import com.amazonaws.services.s3.AmazonS3Client;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.Room;
import hello.hellospring.domain.RoomHasMember;
import hello.hellospring.domain.Ticket;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.RoomRepository;
import hello.hellospring.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {

    private final AmazonS3Client amazonS3Client;

    private final TicketRepository ticketRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;


    @Value("${cloud.aws.s3.bucket}")
    public String bucket; // S3 버킷 이름

    // ticket 및 room DB 에 추가
    public Ticket save(Ticket ticket) {
        // 채팅방 객체 생성
        Room room = roomRepository.save(new Room(ticketRepository.save(ticket).getId()));
        // 티켓 판매자 Member 받기
        Member member = memberRepository.findBy(ticket.getMember().getId()).get();
        ticket.setMember(member);
        ticket.setRoom(room);

        RoomHasMember roomHasMember = new RoomHasMember();
        roomHasMember.setMember(member);
        roomHasMember.setRoom(room);

        member.addRoomHasMember(roomHasMember);
        memberRepository.save(member);

        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    // user_id 로 티켓 조회
    public List<Ticket> findAllByMemberId(Long user_id) {
        return ticketRepository.findAllByMemberId(user_id);
    }


    // 티켓 삭제
    public void remove(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).get();
        String ticketImg = ticket.getTicket_poster();
        amazonS3Client.deleteObject(bucket, ticketImg);
        ticketRepository.deleteById(ticketId);
    }
}
