const toPostData = {
    fonts: [],
    plugins: [],
    cookieEnabled: false,
    platform: "",
    screenResolution: 0,
    userAgent: ""
};
function getDataFromLocalFP() {
    const fpPromise = import("https://openfpcdn.io/fingerprintjs/v4").then(
        (FingerprintJS) => FingerprintJS.load()
    );

    // Get the visitor identifier when you need it.
    fpPromise
        .then((fp) => fp.get())
        .then((result) => {
            console.log("From fp: ")
            console.log(result.components)
            // Replace this with your JSON data
            toPostData.fonts = result.components.fonts.value;
            toPostData.plugins = result.components.plugins.value.map(plugin => plugin.name);
            toPostData.cookieEnabled = result.components.cookiesEnabled.value;
            toPostData.platform = result.components.platform.value;
            toPostData.screenResolution = result.components.screenResolution.value[0] * result.components.screenResolution.value[1];
        })
        .catch((error) => console.error(error));
}

function postData(jsonData) {
    const apiEndpoint = "http://localhost:8080/api/fingerprints";

    const headers = {
        "Content-Type": "application/json",
    };

    // Make the POST request
    fetch(apiEndpoint, {
        method: "POST",
        headers: headers,
        body: JSON.stringify(jsonData),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then((data) => {
            console.log("POST request successful!");
            console.log("Response:", data);
        })
        .catch((error) => {
            console.error("POST request failed:", error);
        }
    );
}

function getFromFP3Public() {
    // Initialize the agent on page load.
    const fpPromise2 = import(
        "https://fpjscdn.net/v3/i67mP4VLZDojYXgjK8xb"
        ).then((FingerprintJS) =>
        FingerprintJS.load({
            region: "eu",
        })
    );

// Get the visitorId when you need it.
    fpPromise2
        .then((fp) => fp.get())
        .then((result) => {
            console.log("From fp2: ")
            console.log(result)
            logFingerprints(result).then(fp => {
                console.log("From server: ")
                console.log(fp)
                toPostData.userAgent = fp.visits[0].browserDetails.userAgent;
            });
        });
}

async function logFingerprints(result) {
    const response = await fetch(
        `https://eu.api.fpjs.io/visitors/${result.visitorId}?api_key=qV6jTuzQLFpRAOR1u33L`
    );
    return await response.json();
}

getDataFromLocalFP();
getFromFP3Public();
console.log(toPostData);