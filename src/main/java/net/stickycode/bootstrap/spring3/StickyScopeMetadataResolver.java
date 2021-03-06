package net.stickycode.bootstrap.spring3;

import net.stickycode.stereotype.StickyDomain;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;


public class StickyScopeMetadataResolver
    implements ScopeMetadataResolver {

  @Override
  public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
    ScopeMetadata metadata = new ScopeMetadata();
    if (definition instanceof AnnotatedBeanDefinition) {
      AnnotatedBeanDefinition annDef = (AnnotatedBeanDefinition) definition;
      if (annDef.getMetadata().hasAnnotation(StickyDomain.class.getName())) {
        metadata.setScopeName("prototype");
      }
      else if (annDef.getMetadata().hasMetaAnnotation(StickyDomain.class.getName())) {
        metadata.setScopeName("prototype");
      }
      else {
        metadata.setScopeName("singleton");
      }
    }
    return metadata;
  }

}
