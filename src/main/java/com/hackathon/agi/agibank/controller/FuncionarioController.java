package com.hackathon.agi.agibank.controller;

import com.hackathon.agi.agibank.domain.Funcionario;
import com.hackathon.agi.agibank.service.FuncionarioService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController implements FuncionarioApi {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @ApiResponse(description = "")
    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return funcionarioService.criarFuncionario(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable String id) {
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @PatchMapping("/{id}")
    public Funcionario alterarStatus(@PathVariable String id, @RequestBody Funcionario funcionario) {
        return funcionarioService.alterarStatus(id, funcionario);
    }


}
