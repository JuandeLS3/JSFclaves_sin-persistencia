package com.huerta.bean;
import com.huerta.model.Elemento;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="obj")
@ViewScoped
public class ViewManager implements Serializable{
  private String key;
  private String value;
  private String last;
  private boolean good;
  private List<Elemento> listClaves = new ArrayList<Elemento>();
  private Map<String, String> datos;

  public ViewManager() {
     good = false;
     //set = new HashSet<String>();
     datos = new HashMap<String, String>();
  }

  public String getLast() {
    return last;
  }
  public List<Elemento> getListClaves() {
    /*listClaves = new ArrayList<Elemento>();
    datos = new Elemento(entry.getKey(),entry.getValue());
    for(Map.Entry<String,String> entry : datos.entrySet()) {
      listClaves.add(new Elemento(entry.getKey(),entry.getValue()));
    }*/
	
    return listClaves;
  }

  public void setListClaves(List<Elemento> listClaves) {
    this.listClaves = listClaves;
  }

  public Map<String,String> datos() {
    
    return datos;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
  public boolean isGood() {
    return good;
  }
  public String getValue() {
    return value;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public void setValue(String value) {
    this.value = value;
  }
  
  public void add() {
    System.out.println("=" + this.key + "=" + this.value + "=");
    if (!datos.containsKey(this.key)) { // Si el hash no contiene dicha key...
      datos.put(this.key, this.value);
      this.last = "Introducido";
      //this.good = true;
      System.out.println("Introducido --> "+datos);
    } else {
      this.last = "Clave repetida";
      System.out.println("Clave repetida");
    }
    /*this.setKey("");
    this.setValue("");
    return null;*/
  }

  public void mostrar() {
  if(!good){
    listClaves = new ArrayList<Elemento>();
    for(Map.Entry<String,String> entry : datos.entrySet()) {
      listClaves.add(new Elemento(entry.getKey(),entry.getValue()));
      System.out.println("Mostrar: "+entry.getKey() + " ---- " + entry.getValue());
      this.good = true;
    }
  } else {
    listClaves = new ArrayList<Elemento>();
    this.good = false;
    }
  }
}
