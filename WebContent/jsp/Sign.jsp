							<div class="content center"><b>
								<span><input type="button" onclick="signup()" value="&nbsp;Sign Up&nbsp;" class="button text-white cyan round-xlarge"></span>
								<span><input type="button" onclick="signin()" value="&nbsp;Sign In&nbsp;" class="button text-white cyan round-xlarge"></span>
							</b>
							</div>
							<br>
							<!-- sign up form -->
							<div id="signup" class="content text-cyan">
								<form action="./SignUp" method="post">
									<div class="content">
										<span class="left" style="float:left;width:50%">Enter Your Name:</span>
										<span style="float:left;width:50%">
											<input type="text" name="name" maxlength="15" class="input text-cyan round-xxlarge" required="" placeholder="Max 15 Character">
										</span>
									</div>
									<div class="content">
										<span  class="left" style="float:left;width:50%">Enter Password:</span>
										<span style="float:left;width:50%">
											<input type="password" id="password" maxlength="10" onkeyup="chkPass()" class="input text-cyan round-xxlarge" required="" placeholder="Min 8 & Max 10">
										</span>
									</div>
									<div class="content">
										<span  class="left" style="float:left;width:50%">Confirm Password:</span>
										<span style="float:left;width:50%">
											<input type="password" name="password" id="c_password" maxlength="10" onkeyup="conPass()" class="input text-cyan round-xxlarge" required="" placeholder="Password">
										</span>
									</div>
									<div class="content center text-red">
										<span id="cnf"></span>
									</div>
									<br>
									<div class="content center">
										<span><input type="submit" id="sign" value="Submit" class="button text-white cyan round-xlarge"></span>
									</div>
								</form>
							</div>
							<!-- sign in form -->
							<div id="signin" class="content text-cyan">
								<form method="post" action="./SignIn">
									<div class="content">
										<span class="left" style="float:left;width:50%">Enter User Id:</span>
										<span style="float:left;width:50%">
											<input type="text" name="userId" class="input text-cyan round-xxlarge" required="" placeholder="User Id">
										</span>
									</div>
									<div class="content">
										<span  class="left" style="float:left;width:50%">Enter Password:</span>
										<span style="float:left;width:50%">
											<input type="password" name="password" class="input text-cyan round-xxlarge" required="" placeholder="Password">
										</span>
									</div>
									<br>
									<div class="content center">
										<span><input type="submit" value="Submit" class="button text-white cyan round-xlarge"></span>
									</div>
								</form>
							</div>