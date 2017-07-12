package net.stickycode.bootstrap.spring3;

import java.beans.Introspector;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.ClassUtils;

public class VersionedBeanNameGenerator
    implements BeanNameGenerator {

  private Pattern version = Pattern.compile("v[0-9]+");

  @Override
  public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
    return buildVersionedName(definition.getBeanClassName());
  }

  protected String beanName(String typeName) {
    return Introspector.decapitalize(ClassUtils.getShortName(typeName));
  }

  String buildVersionedName(String typeName) {
    StringBuilder builder = new StringBuilder();
    String[] components = typeName.split("\\.");
    for (int i = 0; i < components.length - 1; i++)
      if (version.matcher(components[i]).matches())
        builder.append(components[i]).append(".");
    
    return builder.append(beanName(typeName)).toString();
  }
}
