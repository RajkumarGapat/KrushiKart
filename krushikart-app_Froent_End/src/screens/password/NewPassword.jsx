import React, { useState } from 'react'
import { Container } from 'react-bootstrap'
import { Navigate, useNavigate } from 'react-router-dom'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'
import { toast, Toaster } from 'react-hot-toast'

const NewPassword = () => {
  //   const [email, setEmail] = useState('')
  const navigate = useNavigate()
  const [password, setNewpwd] = useState('')
  const email = localStorage.getItem('email')

  const token = localStorage.getItem('token')

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      const res = await httpClient.post(
        `${base_url}/api/user/newpassword`,
        {
          email,
          password,
        },
        {
          headers: {
            Authorization: token,
          },
        },
      )

      if (res.status === 200) {
        toast.success('Password changed successfully')
        navigate('/api/auth/signin')
      } else {
        toast.error('Something went wrong...')
      }
    } catch (error) {}
  }
  return (
    <div>
      <h1>Change Password</h1>
      {/* <h1>{password}</h1> */}
      <div>
        <div className="row mb-4 ">
          <div className="col-4">
            <form onSubmit={handleSubmit}>
              {/* Email input */}
              {/* <div className="form-outline mb-4">
                <input
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  id="email"
                  className="form-control"
                  placeholder="Entert the Email Address"
                />
              </div> */}

              <div className="form-outline mb-4">
                <input
                  type="password"
                  value={password}
                  onChange={(e) => setNewpwd(e.target.value)}
                  id="newpwd"
                  className="form-control"
                  placeholder="Entert the new password"
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
                      >
                        Change Password
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
export default NewPassword
