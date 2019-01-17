/**
 * 
 */

myApp = angular.module("myApp", []);

myApp.controller("Entity", function($scope) {
	
	$scope.persons = [
	                 {name:"Jefry"},
	                 {name:"Peter"},
	                 {name:"Jonh"}
	                 ];
	
});