package com.taras_overmind.scheduleApp.repository;

import com.taras_overmind.scheduleApp.model.entity.PlannedAppointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomQueries extends CrudRepository<PlannedAppointment, Long> {
    @Query(value = "Select wd.name as WeekDay, l.name as Lecturer, s.name as Subject, pa.number as Number " +
            "from group_appointment ga " +
            "join planned_appointment pa on ga.planned_appointment_id=pa.id " +
            "join group_of_students gos on gos.id=ga.group_of_students_id\n" +
            "join lecturer l on l.id=pa.lecturer_id\n" +
            "join week_day wd on wd.index=pa.week_day\n" +
            "join subject s on s.id=pa.subject_id\n" +
            "where gos.id=?1 and wd.index=?2", nativeQuery = true)
    List<List<String>> getAppointmentsByGroupAndWeekDay(Long group_id, int weekDay);

    @Query(value = "Select pa.number as Number, s.name as Subject, st.name as Subject_type,  GROUP_Concat(gos.name SEPARATOR ', ') as Groups, pa.info as link\n" +
            "from group_appointment ga\n" +
            "join planned_appointment pa on ga.planned_appointment_id=pa.id\n" +
            "join group_of_students gos on gos.id=ga.group_of_students_id\n" +
            "join lecturer l on l.id=pa.lecturer_id\n" +
            "join week_day wd on wd.index=pa.week_day\n" +
            "join subject s on s.id=pa.subject_id\n" +
            "join subject_type st on s.type=st.index\n" +
            "where l.id=?1 and wd.index=?2\n" +
            "group by pa.number", nativeQuery = true)
    List<List<String>> getAppointmentsByLecturerAndWeekDay(Long lecturer_id, int weekday);
}
