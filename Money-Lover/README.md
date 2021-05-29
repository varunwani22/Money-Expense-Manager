<h1>Money Lover (Clone of money manager app)</h1>
<p>Thhis application allow user to manage their expenses, spendings and earning in well organized manner.</p>
<hr>
<h3>Used Technologies</h3>
<ul>
  <li>Java</li>
  <li>Kotlin</li>
  <li>Room Database</li>
  <li>Firebase</li>
  <li>Recycler View</li>
</ul>  
<hr>
<h3>Features</h3>
<p>This app help user to manage expenses and earning so that user can keep record of important thigs. App have categories like food, cafe, hospital, cab, bill, etc. So that user can keep recording by selecting one of them, the date and time. User can take part in events and can set reminder of that perticular event. There are graph like structure where user get record of his/her expenses by date.</p>
<hr>
<h3>Screenshort and description</h3>
<img src="./WhatsApp Image 2021-03-21 at 10.55.00 AM (3).jpeg" width="500" height="333">
<p>Here are screenshorts of some activities, add transaction- where user can add transaction to app. added transaction is shown is transaction page,and daywise report of added transaction.</p>
<hr>

<h3>Implimentations of Dependencies in project</h3>

 implementation 'com.google.android.material:material:1.2.1'

    def jetpack_version = "2.1.0"
    def anko_version = '0.10.0'
    def arch_version = '2.2.0-alpha01'
    def retrofit_version = "2.6.1"
    def coroutines = "1.1.1"
    def kotlinCoroutineVersion = "1.1.1"
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.core:core-ktx:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    implementation 'com.google.android.material:material:1.1.0-alpha09'
    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"
    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion"
    //Room
    //implementation "androidx.room:room-runtime:$jetpack_version"
    implementation "androidx.room:room-ktx:$jetpack_version"
    kapt "androidx.room:room-compiler:$jetpack_version"
    kapt "com.android.databinding:compiler:$jetpack_version"
    //Anko
    implementation "org.jetbrains.anko:anko-commons:$anko_version"
    // Retrofit & OkHttp
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:logging-interceptor:4.0.1"
    testImplementation "com.android.support.test.espresso:espresso-core:3.0.2"
    testImplementation "androidx.test.ext:junit-ktx:1.1.2-beta01"
    androidTestImplementation "androidx.test.ext:junit-ktx:1.1.2-beta01"
    androidTestImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "android.arch.core:core-testing:2.1.0"
    testImplementation "com.squareup.okhttp3:mockwebserver:3.6.0"
    implementation 'androidx.recyclerview:recyclerview:1.1.0'
    implementation 'androidx.cardview:cardview:1.0.0'
//Glide 
    implementation 'com.github.bumptech.glide:glide:4.8.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'

    androidTestImplementation 'com.android.support.test:runner:1.0.0'
    androidTestCompile "android.arch.core:core-testing:1.1.0"
    testImplementation 'org.robolectric:robolectric:4.0'

//Firebase
    implementation platform('com.google.firebase:firebase-bom:25.12.0')
    implementation 'com.google.firebase:firebase-analytics'
    implementation 'com.google.firebase:firebase-auth'
    implementation 'com.facebook.android:facebook-login:8.1.0'
    implementation 'com.google.android.gms:play-services-auth:19.0.0'

//Library for dimen
    implementation 'com.intuit.sdp:sdp-android:1.0.6'
