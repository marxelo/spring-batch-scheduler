package com.codenotfound.batch;

import com.codenotfound.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toggle-batch-job")
public class CapitalizeNamesJobController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CapitalizeNamesJobScheduler.class);

  @RequestMapping(value = "/person/{firstName}", method = RequestMethod.GET)
  public Person getFirstName(@PathVariable String firstName) {
    boolean toggleEnabled = !capitalizeNamesJobScheduler.isEnabled();
    capitalizeNamesJobScheduler.setEnabled(toggleEnabled);

    String result = "isEnabled=" + toggleEnabled;
    LOGGER.info(firstName);
    LOGGER.info(result);
    return null;

  }

  @Autowired
  CapitalizeNamesJobScheduler capitalizeNamesJobScheduler;

  @GetMapping
  public String toggleBatchJob() {
    boolean toggleEnabled = !capitalizeNamesJobScheduler.isEnabled();
    capitalizeNamesJobScheduler.setEnabled(toggleEnabled);

    String result = "isEnabled=" + toggleEnabled;
    LOGGER.info(result);

    return result;
  }


}
