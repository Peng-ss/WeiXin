package com.Bean;

import java.util.HashMap;

public class TemplateData  extends HashMap<String, Item>{

  public TemplateData(){}
  public TemplateData(String key,Item value){
	  this.put(key, value);
  }
   
}