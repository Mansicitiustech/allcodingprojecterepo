package com.citiustech.repositories;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citiustech.entities.AppointmentTimeSlot;

public interface AppointmentTimeSlotRepo extends JpaRepository<AppointmentTimeSlot,Integer>{

//	@Query("select a from AppointmentTimeSlot a where a.slotStatus = 'Available'")
//	Optional<List<AppointmentTimeSlot>> findByEmployeeId(int id);

//	@Query("select a from AppointmentTimeSlot a where a.slotStatus = 'Available'")
	Optional<List<AppointmentTimeSlot>> findByEmployeeIdAndDate(int employeeId, Date date);

	Optional<AppointmentTimeSlot> findBySlotId(long slotId);

	Optional<List<AppointmentTimeSlot>> findByEmployeeIdAndDateAndSlotStatus(int employeeId, Date appointmentDate, String string);

	@Query("select a from AppointmentTimeSlot a where a.slotStatus IN ('Available','Not Available') AND a.employeeId = :employeeId")
	Optional<List<AppointmentTimeSlot>> findByEmployeeId(int employeeId);

//	@Query("delete from AppointmentTimeSlot a where a.slotId = :slotId")
//	void deleteBySlotId(@Param("slotId") int  slotId);
	
	 @Query(value = "SELECT * FROM AppointmentTimeSlot WHERE  slotId :slotId " , nativeQuery=true)
	 void deleteBySlotId(@Param("slotId") long slotId);

	Optional<List<AppointmentTimeSlot>> findByEmployeeIdAndSlotStatus(int employeeId, String string);

//	@Query("select a from AppointmentTimeSlot a where a.employeeId = :employeeId and date = :date and slotStatus = 'Available'")
//	Optional<List<AppointmentTimeSlot>> findByEmployeeIdAndDateAndSlotStatus(@Param() int employeeId, String dateText,
//			String string);

}
