package hello.hellospring.repository;

import hello.hellospring.domain.Message;
import hello.hellospring.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByRoom(Room room);
}
