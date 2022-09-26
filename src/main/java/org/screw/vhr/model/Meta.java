package org.screw.vhr.model;

/**
 * @author Emin
 * @date 2022/9/22 18:54
 */
public class Meta {
  private Boolean keepAlive;

  private Boolean requireAuth;

  public Boolean getKeepAlive() {
    return keepAlive;
  }

  public void setKeepAlive(Boolean keepAlive) {
    this.keepAlive = keepAlive;
  }

  public Boolean getRequireAuth() {
    return requireAuth;
  }

  public void setRequireAuth(Boolean requireAuth) {
    this.requireAuth = requireAuth;
  }

}
