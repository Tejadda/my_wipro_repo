package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Service
public class PolicyService {

 @Autowired
 private PolicyRepository policyRepository;

 private final Validator validator;

 public PolicyService() {
     LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
     factory.setValidationMessageSource(new ResourceBundleMessageSource());
     validator = factory;
 }

 public List<Policy> getPolicies() {
     return policyRepository.findAll();
 }

 public Policy createPolicy(Policy policy) {
     validatePolicy(policy);
     return policyRepository.save(policy);
 }

 public Policy updatePolicy(Policy policy) {
     validatePolicy(policy);
     return policyRepository.save(policy);
 }

 public void deletePolicy(Long policyId) {
     policyRepository.deleteById(policyId);
 }

 private void validatePolicy(Policy policy) {
     BindingResult result = new BeanPropertyBindingResult(policy, "policy");
     validator.validate(policy, result);
     if (result.hasErrors()) {
         throw new RuntimeException(result.getAllErrors().toString());
     }
 }
}