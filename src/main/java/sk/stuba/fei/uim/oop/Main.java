package sk.stuba.fei.uim.oop;
import sk.stuba.fei.uim.oop.entity.grant.Agency;
import sk.stuba.fei.uim.oop.entity.grant.Project;
import sk.stuba.fei.uim.oop.entity.organization.Organization;
import sk.stuba.fei.uim.oop.entity.organization.University;
import sk.stuba.fei.uim.oop.entity.people.Person;

public class Main {

    public static void main(String[] args) {
        Agency agency = new Agency();
        agency.setName("Agency 1");
        System.out.println(agency.getName());
        agency.addGrant(null, 2024);

        University university = new University();
        university.setName("University 1");

        Project project = new Project();
        project.setProjectName("Project 1");
        project.setApplicant(university);

        Person person = new Person();
        person.setName("John");
        // person.addEmployer(university);

        project.addParticipant(person);
    }
}
