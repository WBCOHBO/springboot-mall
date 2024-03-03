function submitForm(){
    let productId = document.getElementById('productId').value;
    let form = document.getElementById('searchForm');
    form.action = '/searchProduct/' + productId;
    form.submit();
}