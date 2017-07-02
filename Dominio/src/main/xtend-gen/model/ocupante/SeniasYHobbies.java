package model.ocupante;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class SeniasYHobbies {
  private List<String> senias;
  
  private List<String> hobbies;
  
  public SeniasYHobbies(final List<String> senias, final List<String> hobbies) {
    this.senias = senias;
    this.hobbies = hobbies;
  }
  
  @Pure
  public List<String> getSenias() {
    return this.senias;
  }
  
  public void setSenias(final List<String> senias) {
    this.senias = senias;
  }
  
  @Pure
  public List<String> getHobbies() {
    return this.hobbies;
  }
  
  public void setHobbies(final List<String> hobbies) {
    this.hobbies = hobbies;
  }
}
