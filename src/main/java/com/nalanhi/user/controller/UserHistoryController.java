package com.nalanhi.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nalanhi.common.helper.model.ModelHelper;
import com.nalanhi.user.domain.UserHistoryForm;
import com.nalanhi.user.service.UserHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 회원 이력 controller
 * @author jbeomh@gmail.com
 * @date 2018. 4. 11.
 * 
 */
@Api(tags="UserHistory APIs", description="개인회원 이력")
@RestController
public class UserHistoryController {
	
	@ApiOperation(value="최근 리비전 조회", response=UserHistoryForm.HistoryForm.class)
	@GetMapping("/api/users/{seq}/historys/last")
	public Object findLastChangeRevision(@PathVariable Long seq) {
		
		UserHistoryForm.HistoryForm response = ModelHelper.map(userHistoryService.findLastChangeRevision(seq), UserHistoryForm.HistoryForm.class);
		return response;
	}
	
	@ApiOperation(value="모든 히스토리 조회", response=UserHistoryForm.HistoryForm.class)
	@GetMapping("/api/users/{seq}/historys/all")
	public Object findRevisions(@PathVariable Long seq) {
		
		return ModelHelper.list(userHistoryService.findRevisions(seq), UserHistoryForm.HistoryForm.class);
	}
	
	@ApiOperation(value="히스토리를 페이징 + 정렬 조회", response=UserHistoryForm.HistoryForm.class)
	@GetMapping("/api/users/{seq}/historys/paging")
	public Object findRevisions(@PathVariable Long seq, Pageable pageable) {
		
		return ModelHelper.list(userHistoryService.findRevisions(seq, pageable), UserHistoryForm.HistoryForm.class);
	}
	
	@ApiOperation(value="특정 리비전 조회", response=UserHistoryForm.HistoryForm.class)
	@GetMapping("/api/users/{seq}/historys/{revisionNumber}")
	public Object findRevision(@PathVariable Long seq, @PathVariable Integer revisionNumber) {
		
		UserHistoryForm.HistoryForm response = ModelHelper.map(userHistoryService.findRevision(seq, revisionNumber), UserHistoryForm.HistoryForm.class);
		return response;
	}
	
	@ApiOperation(value="특정 리비전으로 원복", response=UserHistoryForm.HistoryForm.class)
	@PatchMapping("/api/users/{seq}/historys/{revisionNumber}/restore")
	public Object restoreRevision(@PathVariable Long seq, @PathVariable Integer revisionNumber) {
		
		UserHistoryForm.HistoryForm response = ModelHelper.map(userHistoryService.restoreRevision(seq, revisionNumber), UserHistoryForm.HistoryForm.class);
		return response;
	}
	
	@Autowired private UserHistoryService userHistoryService = null;
}
