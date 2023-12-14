import puppeteer from 'puppeteer';
import { newInjectedPage } from 'fingerprint-injector';

(async () => {
    const browser = await puppeteer.launch({ headless: false });
    const page = await newInjectedPage(
        browser,
        {
            // constraints for the generated fingerprint
            fingerprintOptions: {
                devices: ['mobile'],
                operatingSystems: ['ios'],
            },
        },
    );

    // ... your code using `page` here
    await page.goto('http://127.0.0.1:8081');
})();