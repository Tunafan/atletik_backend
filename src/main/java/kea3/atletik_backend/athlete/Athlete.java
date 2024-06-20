package kea3.atletik_backend.athlete;

import jakarta.persistence.*;
import kea3.atletik_backend.agegroup.AgeGroup;
import kea3.atletik_backend.club.Club;
import kea3.atletik_backend.discipline.Discipline;
import kea3.atletik_backend.result.resulttype.ResultType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;
    private int age;
    @ManyToOne
    private AgeGroup ageGroup;
    @ManyToOne
    private Club club;
    @ManyToMany
    private List<Discipline> disciplines;
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResultType> results;
    public Athlete(){}
    public Athlete(String name, String gender, int age, AgeGroup ageGroup, Club club, List<Discipline> disciplines, List<ResultType> results) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ageGroup = ageGroup;
        this.club = club;
        this.disciplines = disciplines;
        this.results = results;
    }
}