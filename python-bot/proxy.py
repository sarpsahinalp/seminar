from selenium import webdriver

PROXY = "185.191.236.162:3128"  # HOST can be IP or name
webdriver.DesiredCapabilities.FIREFOX['proxy'] = {
    "sslProxy": PROXY,    # this is the https proxy
    "proxyType": 'manual'
}

with webdriver.Firefox() as driver:
    # Open URL
    driver.get("https://sarpsahinalp.github.io/seminar/")