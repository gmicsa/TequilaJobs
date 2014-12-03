var jobApp = angular.module('jobApp', []);

jobApp.controller('JobController', function ($scope, $http) {
    $http.get('rest/jobs').success(function (data) {
        $scope.jobs = data;
    });
});