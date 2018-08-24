package team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{

	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSex = MALE;
	private String email;
	private String categoryId;

	private List<String> sexList = new ArrayList<String>();
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("familyNameKanaErrorMessageList");
		session.remove("firstNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("loginIdErrorMessageList");
		session.remove("")
	}

}
