package com.ibm.academia.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class UniversidadesRestApplication {

	/*@Autowired
	private AlumnoDAO alumnoDao;*/

	public static void main(String[] args) {

		SpringApplication.run(UniversidadesRestApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner runner()
	{
		return args ->{
			Direccion direccion = new Direccion("calle 77", "11", "848435", "405", "1", "tijuana");
			Persona alumno = new Alumno(null, "Maria", "de las Nieves", "92846873", direccion);

			Persona personaGuardada = alumnoDao.guardar(alumno);
			System.out.println(personaGuardada.toString());

			List<Persona> alumnos = (List<Persona>) alumnoDao.buscarTodos();
			alumnos.forEach(System.out::println);
		};
	}*/

}
