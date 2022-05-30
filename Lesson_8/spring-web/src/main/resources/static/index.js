angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response.data);
                $scope.ProductsList = response.data;
            });
    };

    $scope.filterProduct = function (){
        console.log($scope.changeMinMaxAmount);
        $http({
            url: contextPath + '/products/filter',
            method: 'get',
            params: {
                min: $scope.changeMinMaxAmount.min,
                max: $scope.changeMinMaxAmount.max
            }
        }).then(function (response){
            $scope.loadProducts()
        })
    }

    $scope.changeAmount = function (productId, delta) {
        $http({
            url: contextPath + '/product/change_amount',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});