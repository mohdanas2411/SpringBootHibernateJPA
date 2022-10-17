package com.example.SpringBootFirst.employeeJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RestClient {


    private static RestTemplate restTemplate;
    private static String getAllEmps = "http://localhost:8080/api/emp/show";
    private static String getEmpById = "http://localhost:8080/api/emp/findById/{id}";

    private static String createEmp = "http://localhost:8080/api/emp/save";

    private static String updateEmp = "http://localhost:8080/api/emp/updateById/";
    private static String deleteById = "http://localhost:8080/api/emp/delete/{id}";



    public RestClient(){

        restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }

        interceptors.add(new RestTemplateModificationInterceptor());

        restTemplate.setInterceptors(interceptors);

    }

    public static void main(String[] args) {
new RestClient();
        System.out.println(restTemplate);

        callGetAllEmpsAPI();

//        callGetEmpByIdApi();

//        callCreateEmpApi();

//        callUpdateEmpApi();

        //     callDeleteByIdApi();
    }



    private static void callGetAllEmpsAPI() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> parameters = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(getAllEmps, HttpMethod.GET, parameters, String.class);

        System.out.println("interceptors  = "+result.getHeaders().get("hello").get(0));

        System.out.println("interceptors  = "+result.getHeaders().getDate());
        System.out.println(result);
    }

    private static void callGetEmpByIdApi() {

        HashMap<String, Integer> param = new HashMap<>();
        param.put("id", 229);

        Employee emp = restTemplate.getForObject(getEmpById, Employee.class, param);
        System.out.println(emp.getId() + "  " + emp.getFullname());

        //we can paas id in either way

        Object id = 230;
        Employee emp1 = restTemplate.getForObject(getEmpById, Employee.class, id);
        System.out.println(emp1.getId() + "  " + emp1.getFullname());

    }


    private static void callCreateEmpApi() {
        Employee employee = new Employee();
        employee.setName("kara");
        employee.setAddress("kayi");

//        ResponseEntity<Employee> persistedEmp = restTemplate.postForEntity(createEmp, employee, Employee.class);
        Employee persistedEmp = restTemplate.postForObject(createEmp, employee, Employee.class);
        System.out.println(persistedEmp);

        // System.out.println(persistedEmp.getBody());
    }

    private static void callUpdateEmpApi() {
        Employee employee = new Employee();
        employee.setId(234);
        employee.setName("turan");
        employee.setAddress("ookaab");

        restTemplate.put(updateEmp, employee);

    }

    private static void callDeleteByIdApi() {
        Object id = 235;

        restTemplate.delete(deleteById, id);
    }


}
