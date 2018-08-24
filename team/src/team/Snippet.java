package team;

public class Snippet {
	public List<String> doPasswordCheck(String password, String reConfirmationPassward){
				List<String> resultList = new ArrayList<String>();
				if(!(password.equals(reConfirmationPassward))){
					resultList.add("入力されたパスワードが異なります。");
				}
				return resultList;
			}
}

