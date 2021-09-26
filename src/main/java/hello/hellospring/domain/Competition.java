package hello.hellospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB 가 알아서 생성
    private long id;
    private String cmp_name;
    private String cmp_img;
    private String cmp_place;
    private int cmp_buyIn;
    private String cmp_start;
    private String cmp_end;



}
