package hello.hellospring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class  Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB 가 알아서 생성
    private long id;
    private String user_id;
    private String user_pass;
    private String user_name;
    private String user_phone;
    private String user_loc;

}
