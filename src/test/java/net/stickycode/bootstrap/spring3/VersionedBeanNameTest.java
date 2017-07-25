package net.stickycode.bootstrap.spring3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class VersionedBeanNameTest {

  @Test
  public void names() {
    assertThat(name("net.stickycode.v1.Bean")).isEqualTo("v1.bean");
    assertThat(name("net.v2.stickycode.v1.Bean")).isEqualTo("v2.v1.bean");
    assertThat(name("net.stickycode.Bean")).isEqualTo("bean");
    assertThat(name("net.vxstickycode.Bean")).isEqualTo("bean");
    assertThat(name("net.v2stickycode.Bean")).isEqualTo("bean");
    assertThat(name("net.V2.stickycode.Bean")).isEqualTo("bean");
    assertThat(name("net.stickycode.v1")).isEqualTo("v1");
    assertThat(name("net.stickycode.v1212312.Bean")).isEqualTo("v1212312.bean");
    
    assertThat(name("net.stickycode.v1.someBean")).isEqualTo("v1.someBean");
    assertThat(name("net.v2.stickycode.v1.someBean")).isEqualTo("v2.v1.someBean");
    assertThat(name("net.stickycode.someBean")).isEqualTo("someBean");
    assertThat(name("net.vxstickycode.someBean")).isEqualTo("someBean");
    assertThat(name("net.v2stickycode.someBean")).isEqualTo("someBean");
    assertThat(name("net.V2.stickycode.someBean")).isEqualTo("someBean");
    assertThat(name("net.stickycode.a1")).isEqualTo("a1");
    assertThat(name("net.stickycode.v1212312.someBean")).isEqualTo("v1212312.someBean");
  }

  private String name(String type) {
    return new VersionedBeanNameGenerator().buildVersionedName(type);
  }

}
