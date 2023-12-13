package com.welltalk.caps.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.welltalk.caps.Entity.AppointmentEntity;

import com.welltalk.caps.Repository.AppointmentRepository;
import com.welltalk.caps.Service.AppointmentService;

@RestController
@CrossOrigin(origins = "*")

public class AppointmentController {

	@Autowired 
	AppointmentService appointmentService;
	
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @PostMapping("/setAppointment")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentEntity appointmentEntry) {
        try {
        	appointmentRepository.save(appointmentEntry);
            return ResponseEntity.ok("Journal entry saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving journal entry: " + e.getMessage());
        }
    }
    @GetMapping("/getAppointment/{makeappointmentid}")
    public ResponseEntity<AppointmentEntity> getAppointment(@PathVariable("makeappointmentid") int makeappointmentid) {
        Optional<AppointmentEntity> appointmentEntry = appointmentRepository.findById(makeappointmentid);
        return appointmentEntry.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/getAppointments")
    public List<AppointmentEntity> getAllAppointment() {
        return appointmentRepository.findAll();
    }
   
    @DeleteMapping("/deleteUserAppointment/{makeappointmentid}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("makeappointmentid") int makeappointmentid) {
        Optional<AppointmentEntity> appointmentEntry = appointmentRepository.findById(makeappointmentid);
        if (appointmentEntry.isPresent()) {
            appointmentRepository.deleteById(makeappointmentid);
            return ResponseEntity.ok("Appointment deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
    

    @GetMapping("/getAppointmentsByUserAndDecision/{userid}")
    public ResponseEntity<List<AppointmentEntity>> getAppointmentsByUserAndDecision(
        @PathVariable(name = "userid") Integer userid) {
        try {
            List<AppointmentEntity> appointments = appointmentRepository.findByUseridAndDecision(userid, true);

            if (appointments.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(appointments);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<Object> getRequest() {
        return new ResponseEntity<>(appointmentService.getRequest(), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/{makeappointmentid}")
    public ResponseEntity<Object> deleteRequest(@PathVariable("makeappointmentid") int makeappointmentid){
    	appointmentService.deleteRequest(makeappointmentid);
    	return new ResponseEntity<>("Request deleted successfully", HttpStatus.OK);
    		
    }
    @PutMapping("/{makeappointmentid}")
    public ResponseEntity<Object> updateAppointment(String stringToken, @PathVariable("makeappointmentid") int makeappointmentid){
    	appointmentService.updateAppointment(makeappointmentid, stringToken);
    	return new ResponseEntity<>("Request Updated Successfully", HttpStatus.OK);
    }


}
