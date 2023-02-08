package com.xayrus.pocketPal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xayrus.pocketPal.dto.BudgetDto;
import com.xayrus.pocketPal.exception.BudgetNotFoundException;
import com.xayrus.pocketPal.model.Budget;
import com.xayrus.pocketPal.repository.BudgetRepository;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository, ModelMapper modelMapper) {
        this.budgetRepository = budgetRepository;
        this.modelMapper = modelMapper;
    }

    public List<BudgetDto> getAllBudgets() {
        return budgetRepository.findAll().stream()
                .map(budget -> modelMapper.map(budget, BudgetDto.class))
                .collect(Collectors.toList());
    }

    public BudgetDto createBudget(BudgetDto budgetDto) {
        Budget budget = budgetRepository.save(modelMapper.map(budgetDto, Budget.class));
        return modelMapper.map(budget, BudgetDto.class);
    }

    public BudgetDto updateBudget(long id, BudgetDto budgetDTO) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new BudgetNotFoundException("Budget with id " + id + " not found"));
        budget.setBudgetName(budgetDTO.getBudgetName());
        budget.setAmount(budgetDTO.getAmount());
        budget = budgetRepository.save(budget);
        return modelMapper.map(budget, BudgetDto.class);
    }

    public void deleteBudget(long id) {
        budgetRepository.deleteById(id);
    }

    public Optional<BudgetDto> getBudgetById(long id) {
        return budgetRepository.findById(id)
                .map(budget -> modelMapper.map(budget, BudgetDto.class));
    }
}
