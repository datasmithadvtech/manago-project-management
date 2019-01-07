package manago.com.restbackend.service.impl;

import manago.com.restbackend.repository.EmployeeRepository;
import manago.com.restbackend.service.EmployeeService;
import manago.com.restbackend.shared.response.EmployeeResponse;
import manago.com.restbackend.util.ManagoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ManagoMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ManagoMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeResponse> all() {
        return employeeRepository
                .findAll()
                .stream()
                .map(mapper::employeeToEmployeeResponse)
                .collect(Collectors.toList());
    }

    public EmployeeResponse one(Long id) {
        return mapper.employeeToEmployeeResponse(employeeRepository.findByEmployeeId(id));
    }
}