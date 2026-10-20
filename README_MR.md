# Suraj Personal AI — Android APK Project

हा सुरुवातीचा Android प्रोजेक्ट GitHub Actions द्वारे cloud build करण्यासाठी आहे. तुमचे 941 MB `suraj-ai.gguf` मॉडेल या प्रोजेक्टमध्ये कॉपी केलेले नाही; त्यामुळे ते सुरक्षित राहते.

## सध्याची स्थिती
- मराठी/हिंदी चॅट UI असलेली Android अॅपची बेस आवृत्ती.
- GitHub Actions workflow debug APK बनवेल आणि Artifacts मध्ये ठेवेल.
- **ही अद्याप AI-सक्षम पूर्ण आवृत्ती नाही:** सध्या नमुना उत्तरे येतात. ऑनलाइन AI API आणि GGUF offline inference पुढील टप्प्यात जोडणे बाकी आहे.

## मोफत cloud build
1. GitHub.com वर sign in करा आणि नवीन repository तयार करा, उदा. `SurajPersonalAI-Android`.
2. या ZIP ला extract करा. Extract झालेल्या `SurajPersonalAI_Android_Project` फोल्डरमधील सर्व फाइल्स repository च्या root मध्ये upload करा (ZIP फाइल स्वतः upload करू नका).
3. `Actions` tab उघडा. Workflow दिसल्यावर `Build Android APK` निवडा → `Run workflow`.
4. Workflow यशस्वी झाल्यावर त्या run मध्ये `Artifacts` मधून `SurajPersonalAI-debug-apk` डाउनलोड करा.
5. Artifact ZIP extract करून APK install करा. Android कडून परवानगी विचारल्यास डाउनलोड केलेल्या APK साठीच install permission द्या.

GitHub च्या मोफत वापराच्या मर्यादा लागू होतात; build साठी पैसे देण्याची गरज नसावी, पण quota/limits बदलू शकतात. APK install करण्यापूर्वी फक्त स्वतःच्या repository मधून build झाल्याची खात्री करा.

## महत्त्वाची नोंद
हा प्रोजेक्ट model file समाविष्ट करत नाही. तुमचे `suraj-ai.gguf` Termux मधून हटवू नका. APK मध्ये 941 MB मॉडेल embed न केल्याने APK छोटा राहतो. पुढे offline model चालवण्यासाठी Android native inference integration आवश्यक आहे.
