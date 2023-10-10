package tn.esprit.appointmentservice.Mappers;

import tn.esprit.appointmentservice.Dto.AppointmentDto;
import tn.esprit.appointmentservice.entities.Appointment;

public class AppointmentMapper {
    public static Appointment mapToEntity(AppointmentDto appointmentDto){

        return Appointment.builder()
                .id(appointmentDto.getId())
                .reason(appointmentDto.getReason())
                .createdAt (appointmentDto.getCreatedAt())
                .comments(appointmentDto.getComments())
                .firstVisit (appointmentDto.isFirstVisit())
                .appointmentDate(
                        (appointmentDto.getAppointmentStart() == null ? null :appointmentDto.getAppointmentStart().toLocalDate())
                )
                .appointmentStartTime(
                        (appointmentDto.getAppointmentStart() == null ? null : appointmentDto.getAppointmentStart().toLocalTime())
                )
                .appointmentEndTime(

                        ( appointmentDto.getAppointmentEnd() == null ? null : appointmentDto.getAppointmentEnd().toLocalTime())
                )
                .appointmentStatus(appointmentDto.getAppointmentStatus())
                .build();
    }
    public static AppointmentDto mapToDto(Appointment appointment){
        return AppointmentDto.builder()
                .id(appointment.getId())
                .reason(appointment.getReason())
                .createdAt (appointment.getCreatedAt())
                .comments(appointment.getComments())
                .FirstVisit (appointment.isFirstVisit())
                .appointmentStart(appointment.getAppointmentDate().atTime(appointment.getAppointmentStartTime()))
                .appointmentEnd(appointment.getAppointmentDate().atTime(appointment.getAppointmentEndTime()))
                .appointmentStatus(appointment.getAppointmentStatus())
                .build();
    }

}
