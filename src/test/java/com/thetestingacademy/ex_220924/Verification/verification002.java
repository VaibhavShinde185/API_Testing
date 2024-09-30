package com.thetestingacademy.ex_220924.Verification;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class verification002 {


    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Test
    public void testVerifyAssertJ(){
        String name = "Vaibhav";
        assertThat(name).isEqualTo("Vaibhav").isNotEmpty().isNotNull();

        List<String> names = Arrays.asList("John", "Jane", "Doe");
        assertThat(names).hasSize(3).isNotNull();

        LocalDate date = LocalDate.now();
        System.out.println(date);

        File file = new File("TestData.json");
        assertThat(file).exists().isFile().canRead();

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Jane", 30);

        assertThat(ages).hasSize(2).containsEntry("John",25).doesNotContainValue(40);

    }

}
