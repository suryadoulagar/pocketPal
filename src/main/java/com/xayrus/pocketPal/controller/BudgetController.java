package com.xayrus.pocketPal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xayrus.pocketPal.dto.ApiResponse;
import com.xayrus.pocketPal.dto.BudgetDto;
import com.xayrus.pocketPal.service.BudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

	private final BudgetService budgetService;

	@Autowired
	public BudgetController(BudgetService budgetService) {
		this.budgetService = budgetService;
	}

	@GetMapping
	public ResponseEntity<List<BudgetDto>> getAllBudgets() {
		return ResponseEntity.ok(budgetService.getAllBudgets());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BudgetDto> getBudgetById(@PathVariable long id) {
		return ResponseEntity.of(budgetService.getBudgetById(id));
	}

	@PostMapping
	public ResponseEntity<BudgetDto> createBudget(@Valid @RequestBody BudgetDto budgetDto) {
		return ResponseEntity.ok(budgetService.createBudget(budgetDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BudgetDto> updateBudget(@PathVariable long id, @Valid @RequestBody BudgetDto budgetDto) {
		return ResponseEntity.ok(budgetService.updateBudget(id, budgetDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteBudget(@PathVariable Long id) {
		budgetService.deleteBudget(id);
		return ResponseEntity.ok(new ApiResponse("record deleted successfully"));
	}
}
