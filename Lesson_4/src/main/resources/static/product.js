angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/product/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.changeScoreProduct = function (id, amount){
        $http({
            url: contextPath + '/product/change_score_product',
            method: 'GET',
            params: {
                id: id,
                amount: amount
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.deleteProduct = function (id){
        $http({
            url: contextPath + '/product/delete',
            method: 'GET',
            params: {
                id: id
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();
});