package Users;

/**
 * Clase que representa a un usuario e incluye metodos constructores y accesores.
 * @author juanpcs
 *
 */
public class UserVO {
	/**
	 * Atributo tipo String que representa el nombre de usuario.
	 */
	String name;
	
	/**
	 * Atributo tipo String que representa el apellido del usuario.
	 */
	String lastName;
	
	/**
	 * Atributo tipo String que representa la fecha de nacimiento del usuario.
	 */
	String birthday;
	
	/**
	 * Atributo tipo String que representa el correo electronico del usuario.
	 */
	String email;
	
	/**
	 * Atributo tipo long que representa el numero telefonico del usuario.
	 */
	long number;
	
	/**
	 * Atributo tipo String que representa la compañia en la que trabaja el usuario.
	 */
	String company;
	
	/**
	 * Metodo constructor que permite instanciar la clase sin inicializar sus atributos.
	 */
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor que permite instanciar la clase inicializando cada uno de sus atributos.
	 * @param name Nombre del usuario.
	 * @param lastName Apellido del usuario.
	 * @param birthday Fecha de nacimiento del usuario.
	 * @param email Correo electronico del usuario.
	 * @param number Numero telefonico del usuario.
	 * @param company Compañia en la que trabaja el usuario.
	 */
	public UserVO(String name, String lastName, String birthday, String email, long number, String company) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.number = number;
		this.company = company;
	}

	/**
	 * Metodo accesor que permite obtener el nombre de la instancia actual de la clase.
	 * @return Nombre del usuario.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo accesor que permite modificar el nombre de la instancia actual de usuario.
	 * @param name Nombre del usuario.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo accesor que permite obtener el apellido de la instancia actual de usuario.
	 * @return Apellido del usuario.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Metodo accesor que permite modificar el apellido de la instancia actual de usuario.
	 * @param lastName Apellido del usuario.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Metodo accesor que permite obtener la fecha de nacimiento de la instancia actual de usuario.
	 * @return Fecha de nacimiento del usuario.
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Metodo accesor que permite modificar la fecha de nacimiento de la instancia actual de usuario.
	 * @param birthday Fecha de nacimeinto del usuario.
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Metodo accesor que permite obtener el correo electronico de la instancia actual de usuario.
	 * @return Correo electronico del usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo accesor que permite modificar el correo electronico de la instancia actual de usuario.
	 * @param email Correo electronico del usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo accesor que permite obtener el numero telefonico de la instancia actual de usuario.
	 * @return Numero telefonico del usuario.
	 */
	public long getNumber() {
		return number;
	}

	/**
	 * Metodo accesor que permite modificar el numero telefonico de la instancia actual de usuario.
	 * @param number Numero telefonico del usuario.
	 */
	public void setNumber(long number) {
		this.number = number;
	}

	/**
	 * Metodo accesor que permite obtener la compañia de trabajo de la instancia actual de usuario.
	 * @return Compañia de trabajo del usuario.
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Metodo accesor que permite modificar la compañia de trabajo de la instancia actual de usuario.
	 * @param company Compañia de trabajo del usuario.
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
