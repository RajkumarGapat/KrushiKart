import React, { useState } from 'react'
import { Container } from 'react-bootstrap'
import { Navigate, useNavigate } from 'react-router-dom'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'
import { toast, Toaster } from 'react-hot-toast'
import { useAuth } from '../../context/auth'

const ForgotPassword = () => {
  const [auth, setAuth] = useAuth()
  const [email, setEmail] = useState('')
  const navigate = useNavigate()

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      const res = await httpClient.get(`${base_url}/api/user/forgotpassword`, {
        params: { email },
      })

      if (res.status === 200) {
        toast.success('email successfully')
        navigate('/api/user/verify')
        console.log(res.data)
        // setAuth({
        //   ...auth,
        //   user: res.data.user,
        //   token: res.data.jwt,
        // })
        // localStorage.setItem('auth', JSON.stringify(res.data))
        // localStorage.setItem('auth', JSON.stringify(res.data))
        localStorage.setItem('email', email)
        // localStorage.setItem('user', res.data.jwt)
        // // window.location.reload()
      } else {
        toast.error('Please Verify Email Address')
      }
    } catch (error) {}
  }

  console.log(email)
  return (
    <div>
      <h1>Forgot Password</h1>
      <div>
        <div className="row mb-4 ">
          <div className="col-4">
            <form onSubmit={handleSubmit}>
              {/* Email input */}
              <div className="form-outline mb-4">
                <input
                  type="text"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  id="email"
                  className="form-control"
                  placeholder="Entert the Email Address"
                />
              </div>

              <hr />

              <div className="row mb-4">
                <div className="col">
                  <div className="form-outline">
                    <div className="text-center">
                      <button
                        type="submit"
                        className="btn btn-primary btn-block mb-4 "
                        // onClick={() => {
                        //   navigate('/api/user/verify')
                        // }}
                      >
                        get OTP
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      )
    </div>
  )
}

export default ForgotPassword
