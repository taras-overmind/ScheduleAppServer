package com.taras_overmind.scheduleApp.repository;

import com.taras_overmind.scheduleApp.model.dto.LecturerDTO;
import com.taras_overmind.scheduleApp.model.entity.PlannedAppointment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomQueries extends CrudRepository<PlannedAppointment, Long> {
    @Query(value = "Select  pa.number as Number, s.name as Subject, st.name as Subject_type, l.name as Lecturer,  pa.info as Link\n" +
            "from group_appointment ga\n" +
            "join planned_appointment pa on ga.planned_appointment_id=pa.id\n" +
            "join group_of_students gos on gos.id=ga.group_of_students_id\n" +
            "join lecturer l on l.id=pa.lecturer_id\n" +
            "join week_day wd on wd.index=pa.week_day\n" +
            "join subject s on s.id=pa.subject_id\n" +
            "join subject_type st on s.`type`=st.`index`\n" +
            "where gos.name=?1 and wd.index=?2\n" +
            "order by pa.number", nativeQuery = true)
    List<List<String>> getAppointmentsByGroupAndWeekDay(String group_name, int weekDay);

    @Query(value = "Select pa.id as id, pa.number as Number, s.name as Subject, st.name as Subject_type,  GROUP_Concat(gos.name SEPARATOR ', ') as Groups, pa.info as link\n" +
            "from group_appointment ga\n" +
            "join planned_appointment pa on ga.planned_appointment_id=pa.id\n" +
            "join group_of_students gos on gos.id=ga.group_of_students_id\n" +
            "join lecturer l on l.id=pa.lecturer_id\n" +
            "join week_day wd on wd.index=pa.week_day\n" +
            "join subject s on s.id=pa.subject_id\n" +
            "join subject_type st on s.type=st.index\n" +
            "where l.email=?1 and wd.index=?2\n" +
            "group by pa.number\n" +
            "order by pa.number", nativeQuery = true)
    List<List<String>> getAppointmentsByLecturerAndWeekDay(String email, int weekday);

    @Query(value = "Select name from faculty", nativeQuery = true)
    List<String> getFaculties();
    @Query(value = "Select group_of_students.name from group_of_students \n" +
            "join faculty on group_of_students.faculty_id=faculty.id\n" +
            "Where faculty.name=?1\n" +
            "order by group_of_students.name", nativeQuery = true)
    List<String> getGroups(String faculty_name);

    @Query(value = "Select name, position, email " +
            "From lecturer " +
            "where email=?1 ", nativeQuery = true)
    List<List<String>> getLecturerByEmail(String email);
    @Modifying
    @Query(value = "Update planned_appointment set info=:link  where id=:id", nativeQuery = true)
    void setNewLinkByID(@Param("link")String newLink, @Param("id") String id);

}
