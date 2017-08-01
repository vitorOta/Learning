<?php
namespace Oreilly\ModernPHP\Url;

class Scanner
{
    /**
    * @var array An array of URLs
    */
    protected $urls;

    /**
    * @var httpClient \GuzzleHttp\Client
    */
    protected $httpClient;

    /**
    * Constructor
    * @param array $urls An array of URLs to scan
    */

    /**
    * Constructor
    * @param array $urls An array of URLs to scan
    */
    public function __construct(array $urls)
    {
        $this->urls = $urls;
        $this->httpClient = new \GuzzleHttp\Client();
    }

    /**
    * Get invalid URLs
    * @return array
    */
    public function getInvalidUrls()
    {
        $invalidUrls=[];
        foreach ($this->urls as $url) {
            try {
                $statusCode= $this->getStatusCodeForUrl($url);
            } catch (\Exception $e) {
                $statusCode=500;
            }

            if ($statusCode>=400) {
                \array_push($invalidUrls, ['url'=>$url, 'status'=>$statusCode]);
            }
        }

        return $invalidUrls;
    }

    protected function getStatusCodeForUrl($url)
    {
        $httpResponse = $this->httpClient->request('GET', $url);
        return $httpResponse->getStatusCode();
    }
}
