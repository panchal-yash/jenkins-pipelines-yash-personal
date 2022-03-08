pipeline{

	agent {label "master"}

	options{

		timestamps()

	}

	stages{

		stage("First stage"){
			steps{
			sh "echo Hello"
			}
		}

		stage("Cloning the sample repo"){
			steps{

				checkout([$class: 'GitSCM', 
							branches: [[name: '*/master']], 
							doGenerateSubmoduleConfigurations: false, 
							extensions: [[$class: 'RelativeTargetDirectory', 
							relativeTargetDir: 'checkout-directory']], 
							submoduleCfg: [], 
							userRemoteConfigs: [[url: 'https://github.com/luxengine/math.git']]])

				sh "ls -la"	
			}


		}


	}




}
