package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Room;
import hello.hellospring.domain.RoomHasMember;
import hello.hellospring.domain.Ticket;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.RoomRepository;
import hello.hellospring.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

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
        ticketRepository.deleteById(ticketId);
    }
}
