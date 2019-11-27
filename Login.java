import java.util.ArrayList;

public class Login{
  private String username;
  private String password;
  private int flag;
  private ArrayList<String[]> mechLogins;

  public Login(){
    this.username = "admin";
    this.password = "admin";

    this.mechLogins = new ArrayList<String[]>();
  }

  public void setAdmin(String str, String str2){
    this.username = str;
    this.password = str2;
  }

  public int getFlag(){
    return this.flag;
  }

  public void setLogin(String id, String str, String str2){
    String login[] = new String[3];

    login[0] = id;
    login[1] = str;
    login[2] = str2;

    if(checkLogin(str,str2) == 1){
      mechLogins.add(login);
    }
    else{
      System.out.println("Username or Password already used.");
    }
  }

  public int checkLogin(String str, String str2){
    int i;
    int flag = 1;

    for(i=0;i < mechLogins.size(); i++){
      if(mechLogins.get(i)[1] == str){
        flag = 0;
      }
    }

    for(i=0;i < mechLogins.size(); i++){
      if(mechLogins.get(i)[2] == str){
        flag = 0;
      }
    }

    return flag;
  }

  public int checkID(String str){
    int i;

    for(i=0;i < mechLogins.size(); i++){
      if(mechLogins.get(i)[0] == str){
        return i;
      }
    }

    return 0;
  }

  public void removeLogin(String str){
    int check = checkID(str);

    if(check != 0){
      mechLogins.remove(check);
    }
    else{
      System.out.println("ID Not Found.");
    }
  }
}
