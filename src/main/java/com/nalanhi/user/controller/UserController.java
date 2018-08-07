package com.nalanhi.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.nalanhi.common.helper.model.ModelHelper;
import com.nalanhi.user.domain.UserForm;
import com.nalanhi.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 3. 30.
 * 
 */
@Api(tags="User APIs", description="개인회원")
@RestController
public class UserController {
	
	@ApiOperation(value="회원 검색", response=UserForm.ListForm.class)
	@PostMapping("/api/users/search")
	public Object search(@Valid @RequestBody UserForm.SearchForm searchForm, BindingResult bind) {
		
		return ModelHelper.list(userService.searchList(searchForm), UserForm.ListForm.class);
	}
	
	@ApiOperation(value="회원 등록", response=UserForm.ResponseForm.class)
	@PostMapping("/api/users")
	public Object insert(@Valid @RequestBody UserForm.InsertForm insertForm, BindingResult bind) {
		
		UserForm.ResponseForm response = ModelHelper.map(userService.insert(insertForm), UserForm.ResponseForm.class);
		return response;
	}
	
	@ApiOperation(
			value="회원 목록", 
			notes="예) /api/users?page=1&size=10&sort=userNo,desc&sort=regDate,asc",
			response=UserForm.ListForm.class
	)
	@GetMapping("/api/users")
	public Object findAll(Pageable pageable){
		
		return ModelHelper.page(userService.selectList(pageable), UserForm.ListForm.class, pageable);
	}
	
	@ApiOperation(value="회원 조회", response=UserForm.ResponseForm.class)
	@GetMapping("/api/users/{seq}")
	public Object findOne(@PathVariable Long seq){
		
		UserForm.ResponseForm response = ModelHelper.map(userService.select(seq), UserForm.ResponseForm.class);
		return response;
	}
	
	@ApiOperation(value="회원 수정", response=UserForm.ResponseForm.class)
	@PutMapping("/api/users/{seq}")
	public Object update(@PathVariable Long seq, @Valid @RequestBody UserForm.UpdateForm updateForm, BindingResult bind){
		
		UserForm.ResponseForm response = ModelHelper.map(userService.update(updateForm, seq), UserForm.ResponseForm.class);
		return response;
	}
	
	@ApiOperation(value="생일 수정", response=UserForm.ResponseForm.class)
	@PatchMapping("/api/users/{seq}/birthdt")
	public Object updateBirthDt(@PathVariable Long seq, @Valid @RequestBody UserForm.UpdateBirthDtForm updateBirthDtForm, BindingResult bind){
		
		UserForm.ResponseForm response = ModelHelper.map(userService.updateBirthDt(updateBirthDtForm, seq), UserForm.ResponseForm.class);
		return response;
	}
	
	@ApiOperation(value="회원 삭제", response=UserForm.ResponseForm.class)
	@DeleteMapping("/api/users/{seq}")
	public Object delete(@PathVariable Long seq){
		
		UserForm.ResponseForm response = ModelHelper.map(userService.delete(seq), UserForm.ResponseForm.class);
		return response;
	}
	
	@Autowired private UserService userService = null;
}
