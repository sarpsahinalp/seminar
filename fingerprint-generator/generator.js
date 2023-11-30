import { chromium } from 'playwright';
import { newInjectedContext } from 'fingerprint-injector';

(async () => {
    const browser = await chromium.launch({ headless: false });
    const context = await newInjectedContext(
        browser,
        {
            // Constraints for the generated fingerprint (optional)
            fingerprintOptions: {
                devices: ['mobile'],
                operatingSystems: ['ios'],
            },
            // Playwright's newContext() options (optional, random example for illustration)
            newContextOptions: {
                geolocation: {
                    latitude: 51.50853,
                    longitude: -0.12574,
                }
            }
        },
    );

    context.
   // ... your code using `page` here
})();