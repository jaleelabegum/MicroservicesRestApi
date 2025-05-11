package com.example.MicroServiceOne;

import com.example.MicroServiceOne.DAO.TaskDao;
import com.example.MicroServiceOne.DAO.UserDao;
import com.example.MicroServiceOne.Entities.Tasks;
import com.example.MicroServiceOne.Entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
import java.util.Date;


@SpringBootApplication
public class MicroServiceOneApplication implements CommandLineRunner {

	@Autowired
	UserDao userDao;

	@Autowired
	TaskDao taskDao;

	private static final Logger log= LoggerFactory.getLogger(MicroServiceOneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("let fill h2 in-memory database");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//String startDateStr = sdf.format(new Date());
		//String endDateStr = sdf.format(new Date());


		userDao.save(new User("Jali","jalsu4321@gmail.com","jaleelaJalz@13",25,"chennai","India",12345));
		userDao.save(new User("jal","jaleelaMohideen26@gmail.com","jaleelaBegum13",25,"chennai","India",5467));
		userDao.save(new User(null,"@#jaleelaMohideen26@gmail.com","jaleelaBegum13",25,"chennai","India",88899));
		userDao.save(new User("Jalz","jali431@gmail.com","jaleela13",26,"chennai","India",88789));
		userDao.save(new User("Jalz","jalijalz431@gmail.com","jaleela1312",26,"chennai","India",87779));

		taskDao.save(new Tasks("AWS","s3,lambda", new Date(13-10-2022),"high","jali431@gmail.com"));
		taskDao.save(new Tasks("JAVA","Core Java,Advanced Java",new Date(13-10-2026),"high","jalijalz431@gmail.com"));
		taskDao.save(new Tasks("JAVA","Core Java,Advanced Java",new Date(8-10-2025),null,"jalijalz431@gmail.com"));

		log.info("Completed filling a h2 database");




	}
}
