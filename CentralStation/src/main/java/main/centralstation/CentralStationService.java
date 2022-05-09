package main.centralstation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import main.model.TimingstationData;
import main.mongodb.DataService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service("service")
public class CentralStationService implements DataService {
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveToDatabase(Collection<TimingstationData> data) {
        //mongoTemplate.save(Arrays.toString(data));
        ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
        List<TimingstationData> pojos = mapper.convertValue(data, new TypeReference<>() {
        });
        for (TimingstationData d :
                pojos) {
            if (d != null) /*mongoTemplate.save(d);*/ addData(d);
        }
    }

    public MongoCollection<Document> getData() {
        return mongoTemplate.getCollection("data");
    }

    @Override
    public TimingstationData addData(TimingstationData newdata) {
        TimingstationData data = new TimingstationData();
        data.setAltitude(newdata.getAltitude());
        data.setCompetitionData(newdata.getCompetitionData());
        data.setWeatherData(newdata.getWeatherData());
        data.setDistance(newdata.getDistance());
        data.setUnitDistance(newdata.getUnitDistance());
        data.setUnitAltitude(newdata.getUnitAltitude());
        data.setTimingstationID(newdata.getTimingstationID());
        data.setTimestamp(newdata.getTimestamp());
        return mongoTemplate.save(data);
    }

    @Override
    public TimingstationData updateData(TimingstationData data) {
        /*
        Optional<Student> studentOpt = studentRepository.findById(studentExistingDto.getId());
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        Student student = studentOpt.get();
        student.setFirstName(studentExistingDto.getFirstName());
        student.setLastName(studentExistingDto.getLastName());
        student.setEmail(studentExistingDto.getEmail());
        student.setContactNumber(studentExistingDto.getContactNumber());
        student.setCourseName(studentExistingDto.getCourseName());

        student = studentRepository.save(student);

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setContactNumber(student.getContactNumber());
        studentDto.setCourseName(student.getCourseName());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
         */
        return null;
    }

    @Override
    public void deleteData(String dataID) {
/*
if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        studentRepository.deleteById(studentId);
 */
    }

    @Override
    public TimingstationData getDataById(String dataID) {
        /*
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }

        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        Student student = studentOpt.get();

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setContactNumber(student.getContactNumber());
        studentDto.setCourseName(student.getCourseName());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
         */
        return null;
    }

    @Override
    public Page<TimingstationData> getAllDates(Pageable dataPage) {
        /*
        Page<Student> studentsPage = studentRepository.findAll(pageable);

        List<StudentDto> studentsDto = new ArrayList<>();
        Page<StudentDto> studentsDtoPage = new PageImpl<>(studentsDto, pageable, 0);

        if (studentsPage != null && !studentsPage.isEmpty()) {

            studentsPage.getContent().forEach(student -> {
                StudentDto studentDto = new StudentDto();
                studentDto.setId(student.getId());
                studentDto.setFirstName(student.getFirstName());
                studentDto.setLastName(student.getLastName());
                studentDto.setEmail(student.getEmail());
                studentDto.setContactNumber(student.getContactNumber());
                studentDto.setCourseName(student.getCourseName());
                studentDto.setCreated(student.getCreated());
                studentDto.setModified(student.getModified());

                studentsDto.add(studentDto);
            });
            studentsDtoPage =
                    new PageImpl<>(studentsDto, pageable, studentsPage.getTotalElements());
        }
        return studentsDtoPage;
         */
        return null;
    }

}
