var CACHE_NAME = 'my-site-cache-v1';
var urlsToCache = [
    '/',
    '/index',
    'https://fonts.googleapis.com/icon?family=Material+Icons',
];

self.addEventListener('install', function (event) {
    // Perform install steps
    event.waitUntil(
        caches.open(CACHE_NAME)
            .then(function (cache) {
                console.log('Opened cache');
                return cache.addAll(urlsToCache);
            }).then(function () { console.log('funfou') }, function () { console.log('deu ruim') })
    );
});


self.addEventListener('activate', function(event){
    var cacheWhiteList = ['pages-cache-v1','blog-posts-cache-v1'];
    console.log('mudou');
    event.waitUntil(
        caches.keys().then(function(cacheNames){
            return Promise.all(
                cacheNames.map(cacheName=>{
                    if(cacheWhiteList.indexOf(cacheName) === -1){
                        return caches.delete(cacheName);
                    }
                })
            );
        })
    );
});


self.addEventListener('fetch', function (event) {
    event.respondWith(
        caches.match(event.request)
            .then(function (response) {
                console.log("passou por aqui");
                // return null;
                if (response) {
                    return response;
                }

                let fetchRequest = event.request.clone();
                return fetch(fetchRequest).then(response => {
                    if (!response || response.status !== 200 || response.type !== 'basic') {
                        return response;
                    }

                    console.log(response.type);
                    let responseToCache = response.clone();
                    caches.open(CACHE_NAME)
                        .then(cache => cache.put(event.request, responseToCache));

                    return response;
                });
            })
    );
});