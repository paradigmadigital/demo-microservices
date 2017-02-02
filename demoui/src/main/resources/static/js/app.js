angular.module('demoCarrefourUI', [ 'ngRoute', 'ngResource' ]).config(
		function($routeProvider) {

			$routeProvider.otherwise('/');
			$routeProvider.when('/', {
				templateUrl : 'home.html',
				controller : 'home'
			}).when('/dashboard', {
				templateUrl : 'dashboard.html',
				controller : 'dashboard'
			});

		}).controller('navigation', function($scope, $http, $window, $route) {
	$scope.tab = function(route) {
		return $route.current && route === $route.current.controller;
	};
	if (!$scope.user) {
		$http.get('/user').success(function(data) {
			$scope.user = data;
			$scope.authenticated = true;
		}).error(function() {
			$scope.authenticated = false;
		});
	}
	$scope.logout = function() {
		$http.post('/logout', {}).success(function() {
			delete $scope.user;
			$scope.authenticated = false;
			// Force reload of home page to reset all state after logout
			$window.location.hash = '';
		});
	};
}).controller('home', function() {
}).controller('dashboard', function($scope, $resource) {

	$resource('/comments', {}).get({}, function(data) {
		$scope.commentList = data.commentList;
	}, function() {
		$scope.commentList = '';
	});

});