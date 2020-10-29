package com.manage.mall.entitys;

import java.util.List;

public class TMenu {

  private long id;
  private String name;
  private String path;
  private String iconpath;
  private long power;
  private List<TSubmenu> submenus;

  public List<TSubmenu> getSubmenus() {
    return submenus;
  }

  public void setSubmenus(List<TSubmenu> submenus) {
    this.submenus = submenus;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  public String getIconpath() {
    return iconpath;
  }

  public void setIconpath(String iconpath) {
    this.iconpath = iconpath;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }

  @Override
  public String toString() {
    return "TMenu{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", path='" + path + '\'' +
            ", iconpath='" + iconpath + '\'' +
            ", power=" + power +
            ", submenus=" + submenus +
            '}';
  }
}
